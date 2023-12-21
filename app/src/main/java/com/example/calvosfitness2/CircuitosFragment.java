package com.example.calvosfitness2;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;

public class CircuitosFragment extends Fragment {

    public CircuitosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_circuitos, container, false);

        ImageButton cuelloButton = rootView.findViewById(R.id.Cuello);
        ImageButton pechoButton = rootView.findViewById(R.id.Pecho);
        ImageButton espaldaButton = rootView.findViewById(R.id.Espalda);
        ImageButton bicepsButton = rootView.findViewById(R.id.Biceps);
        ImageButton tricepsButton = rootView.findViewById(R.id.Triceps);
        ImageButton piernaButton = rootView.findViewById(R.id.Pierna);
        ImageButton antebrazoButton = rootView.findViewById(R.id.antebrazo);
        ImageButton gluteosButton = rootView.findViewById(R.id.gluteos);
        ImageButton cardioButton = rootView.findViewById(R.id.cardio);

        // Configurar OnClickListener para cada ImageButton
        cuelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Cuello");
            }
        });

        pechoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Pecho");
            }
        });

        espaldaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Espalda");
            }
        });


        bicepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Bicps");
            }
        });



        tricepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Triceps");
            }
        });




        piernaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Pierna");
            }
        });




        antebrazoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Antebrazos");
            }
        });
        gluteosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Glúteos");
            }
        });

        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNuevaActividad("Cardio");
            }
        });

        return rootView;
    }

    private void abrirNuevaActividad(String parteDelCuerpo) {
        Intent intent = new Intent(getActivity(), Workout.class);
        intent.putExtra("Circuito", parteDelCuerpo);
        startActivity(intent);
    }
}
