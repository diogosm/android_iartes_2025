package br.edu.ufam.teste_maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class MainActivity extends AppCompatActivity {

    private GeoPoint localizacaoEscolhida;
    private Button salvarLocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                String[] permissoes = {Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissoes, 1);
            }
        }

        //caso dê erro de agentes
        Configuration.getInstance().load(getApplicationContext(), getSharedPreferences("osmdroid", MODE_PRIVATE));
        Configuration.getInstance().setUserAgentValue("br.edu.ufam.teste_maps");

        //Pega o mapa adicionada no arquivo activity_main.xml
        MapView mapa = (MapView) findViewById(R.id.map);
        mapa.setTileSource(TileSourceFactory.MAPNIK);
        //seta algumas configuracoes ao mapa
        mapa.setBuiltInZoomControls(true);
        mapa.setMultiTouchControls(true);

        //Cria um controller para setar posicoes no mapa
        IMapController mapController = mapa.getController();
        mapController.setZoom(9.5);
        GeoPoint startPoint = new GeoPoint(-3.10719, -60.0261); // ponto inicial
        mapController.setCenter(startPoint);

        //pega minha pos atual
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        GeoPoint minhaLoc = null;
        if (location != null) {
            Log.i("debug", "uma localizacao conhecida encontrada!");
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            minhaLoc = new GeoPoint(latitude, longitude);
        }
//        MyLocationNewOverlay myLocationOverlay = new MyLocationNewOverlay(
//                new GpsMyLocationProvider(this), mapa
//        );
//        myLocationOverlay.enableMyLocation(new GpsMyLocationProvider(this));
//        mapa.getOverlays().add(myLocationOverlay);
//        Log.i("debug", "Ta nulo? " +
//                (myLocationOverlay.getMyLocation() == null));
//        Log.i("debug", "Minha localizacao: " +
//                myLocationOverlay.getMyLocation().getLatitude()+
//                " " +
//                myLocationOverlay.getMyLocation().getLongitude());
        //Cria um marcador no mapa
        if(minhaLoc != null){
            Marker startMarker = new Marker(mapa);
            startMarker.setPosition(minhaLoc);
            startMarker.setTitle("Ponto Inicial");
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            mapa.getOverlays().add(startMarker);

            //inicia localizacao
            localizacaoEscolhida = minhaLoc;
        }

        //cria uma variavel pra recebver eventos no mapa
        MapEventsReceiver mReceive = new MapEventsReceiver(){
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                //troca de localizacao com um toque simples
                localizacaoEscolhida = p;
                //como há apenas um marker sempre, apaga o primeiro
                mapa.getOverlays().remove(
                        mapa.getOverlays().size() - 1
                );
                //cria novo marcador
                Marker startMarker = new Marker(mapa);
                startMarker.setPosition(localizacaoEscolhida);
                startMarker.setTitle("Ponto Inicial");
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                mapa.getOverlays().add(startMarker);
                return false;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                // faz nada
                return false;
            }
        };

        //adiciona esse callback de eventos ao mapa
        MapEventsOverlay mapEventsOverlay = new MapEventsOverlay(mReceive);
        mapa.getOverlays().add(0, mapEventsOverlay);

        //eventos do botao salvar
        salvarLocalizacao = (Button) findViewById(R.id.button);
        salvarLocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (localizacaoEscolhida != null) {
                    double latitude = localizacaoEscolhida.getLatitude();
                    double longitude = localizacaoEscolhida.getLongitude();

                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Minha localizacao escolhida:\n"+
                                    latitude + "/" + longitude,
                            Toast.LENGTH_LONG
                    );
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                // Se a solicitação de permissão foi cancelada o array vem vazio.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permissão cedida, recria a activity para carregar o mapa, só será executado uma vez
                    this.recreate();
                }
            }
        }
    }
}