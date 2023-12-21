package com.example.calvosfitness2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Cuello2Fragment extends Fragment {

    private ImageView imageViewCuello2;
    private TextView textViewTemporizador;
    private Button buttonStart;

    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;

    private static final long TIEMPO_TOTAL_MILLIS = 60000; // 1 minuto

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuello2, container, false);

        imageViewCuello2 = view.findViewById(R.id.imageViewCuello2);
        textViewTemporizador = view.findViewById(R.id.textViewTemporizador);
        buttonStart = view.findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    // Si el temporizador está en marcha, detenlo
                    detenerTemporizador();
                } else {
                    // Si el temporizador no está en marcha, inícialo
                    iniciarTemporizador();
                }
            }
        });

        return view;
    }

    private void iniciarTemporizador() {
        countDownTimer = new CountDownTimer(TIEMPO_TOTAL_MILLIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Actualizar el temporizador en cada tick
                long minutos = millisUntilFinished / 1000 / 60;
                long segundos = (millisUntilFinished / 1000) % 60;
                String tiempoRestante = String.format("%02d:%02d", minutos, segundos);
                textViewTemporizador.setText(tiempoRestante);
            }

            @Override
            public void onFinish() {
                // Acciones al finalizar el temporizador
                textViewTemporizador.setText("00:00");
                mostrarNotificacion();
            }
        };

        countDownTimer.start();
        timerRunning = true;
        buttonStart.setText("Stop");
    }

    private void detenerTemporizador() {
        countDownTimer.cancel();
        timerRunning = false;
        textViewTemporizador.setText("00:00");
        buttonStart.setText("Start");
    }

    private void mostrarNotificacion() {
        // Crear y mostrar una notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "channel_id")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Tiempo Finalizado")
                .setContentText("¡El tiempo ha terminado!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        notificationManager.notify(2, builder.build());
    }
}
