/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2092317
 */
public interface IStub {
    public ArrayList<Tienda> getTiendas();
    public void setTiendas(Tienda t);
    public void removeTienda(int t);
}
