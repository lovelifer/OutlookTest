package com.android.dev.outlooktest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by fangqiao on 16/7/16.
 */
public class AgendaListAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private LayoutInflater inflater;

    private List<Agenda> agendaList;

    public AgendaListAdapter(Activity context, List<Agenda> agendaList) {
        inflater = LayoutInflater.from(context);
        this.agendaList = agendaList;
    }

    @Override
    public int getCount() {
        return agendaList.size();
    }

    @Override
    public Object getItem(int position) {
        return agendaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_agenda_list, parent, false);

            holder.tvAgendaDate = (TextView) convertView.findViewById(R.id.tv_agenda_date);
            holder.tvAgendaSubject = (TextView) convertView.findViewById(R.id.tv_agenda_subject);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Agenda agenda = this.agendaList.get(position);

        if (agenda != null) {

            holder.tvAgendaDate.setText(TimeFormatUtils.dateToStr(agenda.getDate(),"HH:mm"));
            holder.tvAgendaSubject.setText(agenda.getSubject());
        }

        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.header_agenda_list, parent, false);
            holder.tvAgendaListHeader= (TextView) convertView.findViewById(R.id.tv_agenda_header);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //set proj_plans_header text as first char in name
        String headerText = TimeFormatUtils.dateToStr(this.agendaList.get(position).getDate(),"MM-dd");
        holder.tvAgendaListHeader.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        //return the first character of the country as ID because this is what headers are based upon
        Date date = this.agendaList.get(position).getDate();
        return date.getTime();
    }


    class HeaderViewHolder {
        TextView tvAgendaListHeader;
    }

    class ViewHolder {

        TextView tvAgendaDate;

        TextView tvAgendaSubject;
    }
}
