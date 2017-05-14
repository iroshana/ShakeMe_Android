package com.shakeme;

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Ravindu on 4/2/2017.
 */

public class FragmentLocation extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    GoogleMap gmap;
    MapView mview;
    View view;
    GoogleApiClient gapiclient;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.locate_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mview = (MapView) view.findViewById(R.id.map);
        if (mview != null) {
            mview.onCreate(null);
            mview.onResume();
            mview.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        gmap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        gotolocation(6.848797, 79.885553, 15);
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(6.848797,79.885553)).title("Liberty").snippet("I hope to go there"));
        //CameraPosition liberty = CameraPosition.builder().target(new LatLng(6.848797,79.885553)).zoom(20).bearing(0).tilt(0).build();
        //googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));


        /*gapiclient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        gapiclient.connect();
        markers();*/

    }

    public void markers(){
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.856583, 79.865191)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.840210, 79.884579)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.829343, 79.868152)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.846258, 79.899955)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.868974, 79.890396)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.881645, 79.869951)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.844841, 79.930763)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.893615, 79.854762)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.887178, 79.887159)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.911412, 79.851232)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.919793, 79.858904)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.908748, 79.898113)).title("Pizza Hut"));
        gmap.addMarker(new MarkerOptions().position(new LatLng(6.890021, 79.929348)).title("Pizza Hut"));
    }

    private void gotolocation(double lat, double lan, float zoom) {

        //gmap.addMarker(new MarkerOptions().position(new LatLng()).title(""));
        LatLng ll = new LatLng(lat, lan);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        gmap.moveCamera(update);
        markers();
    }

    LocationRequest location;

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        location = LocationRequest.create();
        location.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        location.setInterval(1000);

        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(gapiclient, location, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location locate) {
        if(locate == null){
            Toast.makeText(getActivity(),"Cannot Get current location",Toast.LENGTH_LONG).show();
        }else{
            LatLng la = new LatLng(locate.getLatitude(),locate.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(la,15);
            gmap.animateCamera(update);
        }
    }
}
