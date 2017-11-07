package com.example.aptivist_u002.a10302017rxjavasample;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aptivist-U002 on 10/30/2017.
 */

public class RxJavaHelper {
    public static void main(String[] args) {

        Integer[] integers = new Integer[]{5, 6, 7, 8};

        List<Integer> integerList = Arrays.asList(9,8,7,6);
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4);
        Observable<Integer> observable2 = Observable.fromArray(integers);
        Observable<Integer> observable3 = Observable.fromIterable(integerList);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("d = [" + d + "]");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("integer = [" + integer + "]");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };



        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("d = [" + d + "]");
            }

            @Override
            public void onNext(String s) {
                System.out.println("s = [" + s + "]");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("e = [" + e + "]");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
//        observable1.subscribe(observer);
//        observable1.subscribe(observer);
//        observable2.subscribe(observer);
//        observable3.subscribe(observer);

//        observable1.concatWith(observable2)
//                .subscribe(observer);

//        observable1.mergeWith(observable2)
//                .subscribe(observer);

        observable1.concatWith(observable2).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer%2 ==0;
            }
        }).subscribe(observer);

//        observable3.map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return String.valueOf(integer);
//            }
//        }).subscribe(stringObserver);
//
//        observable3.map(new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer) throws Exception {
//                return integer*integer;
//            }
//        }).subscribe(observer);
//
//        observable1.zipWith(observable2, new BiFunction<Integer, Integer, String>() {
//            @Override
//            public String apply(Integer integer, Integer integer2) throws Exception {
//                return integer + " - " + integer2;
//            }
//        }).subscribe(stringObserver);


        observable3.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 2 == 1;
            }
        }).subscribeOn(Schedulers.io())//new thread
            .observeOn(Schedulers.single())//new thread
            .subscribe(observer);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
