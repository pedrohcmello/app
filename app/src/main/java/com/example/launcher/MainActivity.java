package com.example.launcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PackageManager packageManager = getPackageManager();
    List<ApplicationInfo> packageInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);



    /* Cria um Intent com a ação ACTION_MAIN, que é usada para filtrar aplicativos
que tenham uma atividade principal. O segundo argumento null indica que não há
um componente específico a ser direcionado neste momento.*/



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.app_name), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//(findViewById(R.id.app_name),  NÃO ENTENDI o erro que aparece quando é (R.id.main).
        // É a primeira vez que vejo esse erro.




    /* ESSA PARTE  COPIEI  da aula

    String[] nomes = new String[]{"Helena", "Lívia", "Gabriel", "Pedro"};

AdapterApps adapterApps = new AdapterApps(this, R.layout.item_lista,installedApps);
    listView = findViewById(R.id.listView);
    listView.setAdapter(adapterApps);


    listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id)->{
        PackageInfo packageInfo = installedApps.get(position);
        String packageName =packageInfo.packageName;
        Intent launchIntent = packageManager.getLaunchIntentForPackage(packageName);
        if(launchIntent != null){
            startActivity(launchIntent);
        }

    }
  ATÉ AQUI    */


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
        String packageName = applicationInfo.packageName;
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

        Intent intent = packageManager.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
        }
    }
};





    //installedApps = new ArrayList<>();














