package net.sikuani.fragmentos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julian on 2/21/15.
 */
public class CustomizedAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<String[]> objects;

    public CustomizedAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //return super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(resource, parent, false);

        ((TextView)view.findViewById(R.id.title)).setText(objects.get(position)[0]);
        ((TextView)view.findViewById(R.id.subtitle)).setText(objects.get(position)[1]);

        return view;
    }
}
