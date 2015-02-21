package net.sikuani.fragmentos;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Receiver extends Fragment {


    public Receiver() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receiver, container, false);
    }


    public void receiveData(String content){
        //Lo agrego a la lista
        Toast.makeText(getActivity(), "Llegó contenido:"+content, Toast.LENGTH_SHORT).show();
    }


}
