package com.ImanPay.demoui.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ImanPay.demoui.R;

import java.util.Calendar;
import java.util.List;

public class CalendarDayAdapter extends RecyclerView.Adapter<CalendarDayAdapter.VH> {

    public interface OnDiaClickListener {
        void onDiaClick(int dia);
    }

    private static final String COLOR_RANGO = "#DDEFEF";
    private final List<Integer> dias;
    private final int year;
    private final int month;
    private final Calendar rangoInicio;
    private final Calendar rangoFin;
    private final OnDiaClickListener listener;

    public CalendarDayAdapter(List<Integer> dias, int year, int month,
                              Calendar rangoInicio, Calendar rangoFin,
                              OnDiaClickListener listener) {
        this.dias = dias;
        this.year = year;
        this.month = month;
        this.rangoInicio = rangoInicio;
        this.rangoFin = rangoFin;
        this.listener = listener;
    }

    static class VH extends RecyclerView.ViewHolder {
        LinearLayout llRangeBg;
        View vLeftHalf, vRightHalf, vTodayRing;
        TextView tvDay;
        VH(View itemView) {
            super(itemView);
            llRangeBg = itemView.findViewById(R.id.llRangeBg);
            vLeftHalf = itemView.findViewById(R.id.vLeftHalf);
            vRightHalf = itemView.findViewById(R.id.vRightHalf);
            vTodayRing = itemView.findViewById(R.id.vTodayRing);
            tvDay = itemView.findViewById(R.id.tvDay);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calendar_day, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Integer dia = dias.get(position);

        if (dia == null) {
            holder.tvDay.setText("");
            holder.tvDay.setBackground(null);
            holder.vLeftHalf.setBackgroundColor(Color.TRANSPARENT);
            holder.vRightHalf.setBackgroundColor(Color.TRANSPARENT);
            holder.vTodayRing.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(null);
            return;
        }

        holder.tvDay.setText(String.valueOf(dia));

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, dia, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Calendar hoy = Calendar.getInstance();
        hoy.set(Calendar.HOUR_OF_DAY, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);
        boolean esHoy = esMismoDia(cal, hoy);

        boolean esInicio = rangoInicio != null && esMismoDia(rangoInicio, cal);
        boolean esFin = rangoFin != null && esMismoDia(rangoFin, cal);
        boolean hayRangoCompleto = rangoInicio != null && rangoFin != null
                && !esMismoDia(rangoInicio, rangoFin);
        boolean enRango = hayRangoCompleto
                && cal.getTimeInMillis() >= rangoInicio.getTimeInMillis()
                && cal.getTimeInMillis() <= rangoFin.getTimeInMillis();

        // Reset
        holder.vLeftHalf.setBackgroundColor(Color.TRANSPARENT);
        holder.vRightHalf.setBackgroundColor(Color.TRANSPARENT);
        holder.tvDay.setBackground(null);
        holder.tvDay.setTextColor(Color.BLACK);

        if (esInicio && hayRangoCompleto) {
            holder.tvDay.setBackgroundResource(R.drawable.bg_day_selected);
            holder.tvDay.setTextColor(Color.WHITE);
            holder.vRightHalf.setBackgroundColor(Color.parseColor(COLOR_RANGO));

        } else if (esFin && hayRangoCompleto) {
            holder.tvDay.setBackgroundResource(R.drawable.bg_day_selected);
            holder.tvDay.setTextColor(Color.WHITE);
            holder.vLeftHalf.setBackgroundColor(Color.parseColor(COLOR_RANGO));

        } else if (esInicio || esFin) {
            holder.tvDay.setBackgroundResource(R.drawable.bg_day_selected);
            holder.tvDay.setTextColor(Color.WHITE);

        } else if (enRango) {
            holder.vLeftHalf.setBackgroundColor(Color.parseColor(COLOR_RANGO));
            holder.vRightHalf.setBackgroundColor(Color.parseColor(COLOR_RANGO));
        }
        holder.vTodayRing.setVisibility(esHoy ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(v -> listener.onDiaClick(dia));
    }

    @Override
    public int getItemCount() {
        return dias.size();
    }

    private boolean esMismoDia(Calendar a, Calendar b) {
        return a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
                && a.get(Calendar.DAY_OF_YEAR) == b.get(Calendar.DAY_OF_YEAR);
    }
}