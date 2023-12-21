package com.example.calvosfitness2;




import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrarNotificacion();

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav_view);
        Menu menu = bottomNavigationView.getMenu();
        getMenuInflater().inflate(R.menu.home, menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.menu_home) {
                            // Home
                        } else if (itemId == R.id.menu_circuito) {
                            // Circuito
                        } else if (itemId == R.id.menu_estadisticas) {
                            // Estadísticas
                        }

                        return true;
                    }
                });
    }

    private void mostrarNotificacion() {
        Notification notification = new Notification.Builder(this)
                .setContentTitle(" Hora de los Burpies!")
                .setContentText("¡Adios mileurista!")
                .setSmallIcon(R.drawable.ic_notificacion_background)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
//eres bobo