package com.desarrollo.apptiempodevida;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.desarrollo.apptiempodevida.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private IncrementalViewModel incrementalViewModel;
    private int res = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        incrementalViewModel = new ViewModelProvider(this).get(IncrementalViewModel.class);
        Log.d("TAG1","onCreate()");
        binding.tvResCon.setText("Con ViewModel: " + incrementalViewModel.getResultado());
        binding.tvResSin.setText("Sin ViewModel: " + res);
        tarea();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("TAG1","onStart()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("TAG1","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("TAG1","onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("TAG1","onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("TAG1","onDestroy()");
    }
    public void tarea(){
        binding.btIncrementarSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = Incrementar.incremento(res);
                binding.tvResSin.setText("Sin ViewModel: " + res);
            }
        });
        binding.btIncrementarCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementalViewModel.setResultado(Incrementar.incremento(incrementalViewModel.getResultado()));
                binding.tvResCon.setText("Con ViewModel: " + incrementalViewModel.getResultado());
            }
        });
    }
}