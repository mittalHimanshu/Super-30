package com.example.phoenix.mynotesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {
    ArrayList<Note> notes;
    NoteAdapter(){
        notes = Note.getNotes();
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NotesViewHolder holder;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_note, viewGroup, false);
            holder = new NotesViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (NotesViewHolder) view.getTag();
        }
        Note note = getItem(i);
        holder.list_note_title.setText(note.getTitle());
        holder.list_note_content.setText(note.getContent());
        if(note.getAlarmTIme().equals("null : null")){
            holder.imageView.setVisibility(View.GONE);
            holder.list_note_date.setText(note.getDateTime());
        }
        else{
            holder.list_note_date.setText(note.getDateTime() + "                   " + note.getAlarmTIme());
        }
        return view;
    }

    class NotesViewHolder {
        TextView list_note_title, list_note_date, list_note_content;
        ImageView imageView;
        NotesViewHolder(View view) {
            imageView =  view.findViewById(R.id.imageView);
            list_note_title = view.findViewById(R.id.list_note_title);
            list_note_date = view.findViewById(R.id.list_note_date);
            list_note_content = view.findViewById(R.id.list_note_content);
        }
    }
}