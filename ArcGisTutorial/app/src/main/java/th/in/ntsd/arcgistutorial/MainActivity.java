package th.in.ntsd.arcgistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISDynamicMapServiceLayer;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.esri.core.map.Graphic;

public class MainActivity extends AppCompatActivity {
    MapView mMapView;
    String mDynamicServiceURL;
    ArcGISDynamicMapServiceLayer mStreetsLayer;
    GraphicsLayer mGraphicsLayer;
    String mFeatureServiceURL;
    ArcGISFeatureLayer mFeatureLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.map);

//// Add Dynamic layer to the MapView
//        mDynamicServiceURL = "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Demographics/ESRI_Population_World/MapServer";
//        mStreetsLayer = new ArcGISDynamicMapServiceLayer(mDynamicServiceURL);
//        mMapView.addLayer(mStreetsLayer);
//
////// Add Graphics layer to the MapView
//        mGraphicsLayer = new GraphicsLayer();
//        mMapView.addLayer(mGraphicsLayer);

// Add Feature layer to the MapView
        //mFeatureServiceURL = this.getResources().getString(R.string.featureServiceQueryURL);
        mFeatureServiceURL = "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Demographics/ESRI_Population_World/MapServer/0";
        mFeatureLayer = new ArcGISFeatureLayer(mFeatureServiceURL, ArcGISFeatureLayer.MODE.ONDEMAND);
        mMapView.addLayer(mFeatureLayer);



    }
}
