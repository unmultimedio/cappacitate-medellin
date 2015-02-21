package net.sikuani.fragmentos;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Receiver extends Fragment {

    ListView lista;

    CustomizedAdapter adapter;

    List<String[]> elements;

    public Receiver() {
        // Required empty public constructor
        elements = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Esta declaración se puede hacer en cualquier punto luego del
        //onAttach, y antes de usarlo en el ListView
        adapter = new CustomizedAdapter(
                getActivity(),
                R.layout.list_item,
                elements);


        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_receiver, container, false);

        lista = (ListView) fragmentView.findViewById(R.id.listView);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"click:"+position,Toast.LENGTH_SHORT).show();
            }
        });

        return fragmentView;
    }


    public void receiveData(String[] content){
        //Lo agrego a la lista
        Toast.makeText(
                getActivity(),
                "Llegó contenido :"+content,
                Toast.LENGTH_SHORT).show();

        elements.add(content);

        //Chequea la lista de elementos, y los carga de nuevo
        adapter.notifyDataSetChanged();

    }


}
