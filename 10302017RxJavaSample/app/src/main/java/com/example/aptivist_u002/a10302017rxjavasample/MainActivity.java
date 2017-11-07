package com.example.aptivist_u002.a10302017rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TAG_";
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.a_main_etxt);
        button = findViewById(R.id.a_main_btn);

        button.setOnClickListener(this);
    }

    public boolean isPrime(int input) {
        if (input == 2) return true;
        if (input %2 == 2) return false;
        for (int i = 3; i < Math.sqrt(input); i+=2) {
            if (input%i ==0) return false;
        }
        return true;

    }

    @Override
    public void onClick(View view) {
        int number = Integer.parseInt(editText.getText().toString());


//        Observable<Integer> integerObservable = Observable.just(number);
//        Observer<Boolean> observer = new Observer<Boolean>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//            @Override
//            public void onNext(Boolean integer) {
//                Toast.makeText(MainActivity.this, integer+"", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onError(Throwable e) {
//            }
//            @Override
//            public void onComplete() {
//            }
//        };
//        integerObservable.map(new Function<Integer, Boolean>() {
//            @Override
//            public Boolean apply(Integer integer) throws Exception {
//                return isPrime(integer);
//            }
//        }).subscribe(observer);


        Observable.just(number)
                .map(integer -> isPrime(integer))
                .subscribe(aBoolean -> Toast.makeText(MainActivity.this, String.valueOf(aBoolean), Toast.LENGTH_SHORT)
                        .show());
    }
}
