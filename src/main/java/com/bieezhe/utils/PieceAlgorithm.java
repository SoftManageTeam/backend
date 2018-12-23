package com.bieezhe.utils;

import java.util.*;

import org.springframework.stereotype.Component;

import com.bieezhe.domain.rider;
import com.bieezhe.domain.seller;

//将utils类加入bean
@Component
public class PieceAlgorithm {
    public static rider PieceAlgorthm(seller seller,LinkedList<rider> Ridder){

        LinkedList<rider> myreturn = new LinkedList<rider>();
        float [] lng = new float[2];//经度
        float [] lat =new float[2];

        lng[0]=(float)( seller.getLongitude()-0.02);
        lng[1]=(float)( seller.getLongitude()+0.02);

        lat[0]=(float)(seller.getLatitude()-0.02);
        lat[1]=(float)(seller.getLatitude()+0.02);

        Iterator<rider> iterable = Ridder.iterator();

        while (iterable.hasNext()){
            rider rid = iterable.next();
            if (rid.getLatitude()>lat[0]&&rid.getLatitude()<lat[1]&&rid.getLongitude()>lng[0]&&rid.getLongitude()<lng[1]){
                myreturn.add(rid);
            }
        }

        if (myreturn.isEmpty()){
            return Ridder.getFirst();
        }
        else {
            rider returnRider = myreturn.getFirst();
            iterable = myreturn.iterator();

            while (iterable.hasNext()){
                rider p = iterable.next();
                if (p.getOrderamount()<returnRider.getOrderamount()){
                    returnRider = p;
                }
            }
            return returnRider;
        }
    }
/*
    public static void main(String[] args){
        LinkedList<rider> ridreturnRiders = new LinkedList<rider>();

        ridreturnRiders.add(new rider((float) 31.192609,(float)121.431577,0));
        ridreturnRiders.add(new rider((float)32.192609,(float)121.431577,0));
        ridreturnRiders.add(new rider((float)31.202609,(float)121.431577,0));
        ridreturnRiders.add(new rider((float)31.192609,(float)121.441577,1));
        ridreturnRiders.add(new rider((float)31.192609,(float)121.431577,2));
        ridreturnRiders.add(new rider((float)31.192609,(float)121.431577,3));
        ridreturnRiders.add(new rider((float)31.192609,(float)121.431577,4));
        ridreturnRiders.add(new rider((float)31.192609,(float)121.431577,5));
		
        seller seller = new seller((float)31.192609,(float)121.431577);

        rider rt = PieceAlgorthm(seller,ridreturnRiders);
        System.out.println(rt.getLongitude()+" "+rt.getLatitude()+" "+rt.getOrderamount());
*/
 
}
