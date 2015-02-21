package net.sikuani.fragmentos;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sender extends Fragment {

    Communicator interfaz;

    public Sender() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        interfaz = (Communicator)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false);
    }

    public void retrieveInfo(){
        EditText text = (EditText) getActivity().findViewById(R.id.senderText);

        String content = text.getText().toString();

        interfaz.sendContent(content);

    }


}
