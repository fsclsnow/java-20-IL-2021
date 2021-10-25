package com.example.java20il2021.week3.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  IStream.of(col) => op1 = new Operation()
 *          .map(x -> x * 2) => op1.map(x -> x * 2) => op2 = new Operation()
 *          .map(x -> new String(x)) => op2.map(..) => op3 = new Operation()
 *          .collect() => this = op3
 *
 *   op1(level = 0) <=> op2(level = 1) <=> op3(level = 2)
 */
public interface IStream<T> {

    static <T> IStream<T> of(Collection<T> col) {
        //Head
        return new Operation<T, T>(col) {
            @Override
            ISink<T> onWrapSink(ISink<T> downstreamSink) {
                return val -> downstreamSink.accept(val);
            }
        };
    }

    <R> IStream<R> map(Function<T, R> mapper);

    IStream<T> filter(Predicate<T> predicate);

    <R> R collect(Supplier<R> supplier, BiConsumer<R, T> accumulator);
}

class TestIStream {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        IStream<Integer> stream = IStream.of(l);
        l.add(3);
        l.add(4);
        List<String> ans = stream.map(x -> x * 2).filter(x -> x < 5).map(x -> String.valueOf(x)).collect(() -> new ArrayList(), (res, val) -> res.add(val));
        System.out.println(ans);
    }
}



