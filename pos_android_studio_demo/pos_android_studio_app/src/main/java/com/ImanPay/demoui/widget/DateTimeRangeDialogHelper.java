package com.ImanPay.demoui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ImanPay.demoui.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DateTimeRangeDialogHelper {
    public interface OnResultadoListener {
        void onResultado(Calendar inicio, Calendar fin,
                         int horaIniH, int horaIniM,
                         int horaFinH, int horaFinM);
    }
    private Calendar mesActual = Calendar.getInstance();
    private Calendar rangoInicio = null;
    private Calendar rangoFin = null;
    private int horaIniH = 0, horaIniM = 0;
    private int horaFinH = 23, horaFinM = 59;
    private AlertDialog dialogRef;
    public void mostrar(Context context, LinearLayout toolbar_btn, OnResultadoListener onResultado) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_date_time_range, null);

        RecyclerView rv = view.findViewById(R.id.rvCalendario);
        TextView tvMesAnio = view.findViewById(R.id.tvMesAnio);
        TextView tvHoraInicio = view.findViewById(R.id.tvHoraInicio);
        TextView tvHoraFin = view.findViewById(R.id.tvHoraFin);
        ImageView btnMesAnterior = view.findViewById(R.id.btnMesAnterior);
        ImageView btnMesSiguiente = view.findViewById(R.id.btnMesSiguiente);
        TextView tvRestaurarFecha = view.findViewById(R.id.tvRestaurarFecha);
        TextView tvRestaurarHora = view.findViewById(R.id.tvRestaurarHora);

        rv.setLayoutManager(new GridLayoutManager(context, 7));
        pintarMes(rv, tvMesAnio, context);

        btnMesAnterior.setOnClickListener(v -> {
            mesActual.add(Calendar.MONTH, -1);
            pintarMes(rv, tvMesAnio, context);
        });

        btnMesSiguiente.setOnClickListener(v -> {
            mesActual.add(Calendar.MONTH, 1);
            pintarMes(rv, tvMesAnio, context);
        });

        tvHoraInicio.setText(String.format(Locale.getDefault(), "%02d:%02d", horaIniH, horaIniM));
        tvHoraFin.setText(String.format(Locale.getDefault(), "%02d:%02d", horaFinH, horaFinM));

        tvHoraInicio.setOnClickListener(v -> abrirTimePicker(context, true, tvHoraInicio, tvHoraFin));
        tvHoraFin.setOnClickListener(v -> abrirTimePicker(context, false, tvHoraInicio, tvHoraFin));

        tvRestaurarFecha.setOnClickListener(v -> {
            rangoInicio = null;
            rangoFin = null;
            pintarMes(rv, tvMesAnio, context);
            actualizarBotonAceptar();
        });

        tvRestaurarHora.setOnClickListener(v -> {
            horaIniH = 0; horaIniM = 0;
            horaFinH = 23; horaFinM = 59;
            tvHoraInicio.setText("00:00");
            tvHoraFin.setText("23:59");
        });

        dialogRef  = new MaterialAlertDialogBuilder(context)
                .setView(view)
                .setPositiveButton("Aceptar", (d, which) -> {
                        onResultado.onResultado(rangoInicio, rangoFin, horaIniH, horaIniM, horaFinH, horaFinM);
                })
                .setNegativeButton("Cancelar", null)
                .create();

        dialogRef.setOnShowListener(d -> actualizarBotonAceptar());
        dialogRef.show();

        dialogRef.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#55ADB0"));
        dialogRef.setOnDismissListener(dialog -> {
            toolbar_btn.setEnabled(true);
        });
    }
    private void pintarMes(RecyclerView rv, TextView tvMesAnio, Context context) {
        int year = mesActual.get(Calendar.YEAR);
        int month = mesActual.get(Calendar.MONTH);

        String mesFormateado = new SimpleDateFormat("MMMM yyyy", new Locale("es")).format(mesActual.getTime());
        if (!mesFormateado.isEmpty()) {
            mesFormateado = Character.toUpperCase(mesFormateado.charAt(0)) + mesFormateado.substring(1);
        }
        tvMesAnio.setText(mesFormateado);

        Calendar primerDia = Calendar.getInstance();
        primerDia.set(year, month, 1, 0, 0, 0);

        int offset = (primerDia.get(Calendar.DAY_OF_WEEK) + 5) % 7;
        int diasEnMes = primerDia.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<Integer> celdas = new ArrayList<>();
        for (int i = 0; i < offset; i++) celdas.add(null);
        for (int d = 1; d <= diasEnMes; d++) celdas.add(d);

        CalendarDayAdapter adapter = new CalendarDayAdapter(
                celdas, year, month, rangoInicio, rangoFin,
                diaClickeado -> {
                    Calendar clickCal = Calendar.getInstance();
                    clickCal.set(year, month, diaClickeado, 0, 0, 0);
                    clickCal.set(Calendar.MILLISECOND, 0);

                    if (rangoInicio == null) {
                        rangoInicio = clickCal;
                        rangoFin = null;
                    } else if (rangoFin == null) {
                        if (clickCal.before(rangoInicio)) {
                            rangoFin = rangoInicio;
                            rangoInicio = clickCal;
                        } else {
                            rangoFin = clickCal;
                        }
                    } else {
                        rangoInicio = clickCal;
                        rangoFin = null;
                    }
                    pintarMes(rv, tvMesAnio, context);
                    actualizarBotonAceptar();
                });
        rv.setAdapter(adapter);
    }
    private void actualizarBotonAceptar() {
        if (dialogRef == null) return;
        Button btnPositivo = dialogRef.getButton(AlertDialog.BUTTON_POSITIVE);
        if (btnPositivo != null) {
            boolean rangoCompleto = rangoInicio != null && rangoFin != null;
            btnPositivo.setEnabled(rangoCompleto);
            if (rangoCompleto){
                dialogRef.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#55ADB0"));
            } else {
                dialogRef.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#878787"));
            }
        }
    }
    private void abrirTimePicker(Context context, boolean esInicio, TextView tvHoraInicio, TextView tvHoraFin) {
        int hActual = esInicio ? horaIniH : horaFinH;
        int mActual = esInicio ? horaIniM : horaFinM;
        tvHoraInicio.setEnabled(false);
        tvHoraFin.setEnabled(false);

        MaterialTimePicker picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(hActual)
                .setMinute(mActual)
                .setTitleText(esInicio ? "Hora de inicio" : "Hora de fin")
                .setPositiveButtonText("Aceptar")
                .setInputMode(MaterialTimePicker.INPUT_MODE_KEYBOARD)
                .build();

        picker.addOnPositiveButtonClickListener(v -> {
            int h = picker.getHour();
            int m = picker.getMinute();
            tvHoraInicio.setEnabled(true);
            tvHoraFin.setEnabled(true);
            if (esInicio) {
                horaIniH = h; horaIniM = m;
                tvHoraInicio.setText(String.format(Locale.getDefault(), "%02d:%02d", h, m));
            } else {
                horaFinH = h; horaFinM = m;
                tvHoraFin.setText(String.format(Locale.getDefault(), "%02d:%02d", h, m));
            }
        });

        picker.addOnDismissListener((selector) -> {
            tvHoraInicio.setEnabled(true);
            tvHoraFin.setEnabled(true);
        });

        if (context instanceof AppCompatActivity) {
            picker.show(((AppCompatActivity) context).getSupportFragmentManager(), "TIME_PICKER");
            new Handler(Looper.getMainLooper()).post(() -> {
                View root = picker.getView();
                if (root != null) {
                    Button btnOk = root.findViewById(com.google.android.material.R.id.material_timepicker_ok_button);
                    Button btnCancel = root.findViewById(com.google.android.material.R.id.material_timepicker_cancel_button);
                    if (btnOk != null) btnOk.setTextColor(Color.parseColor("#55ADB0"));
                    if (btnCancel != null) btnCancel.setTextColor(Color.parseColor("#55ADB0"));
                }
            });
        }
    }
}