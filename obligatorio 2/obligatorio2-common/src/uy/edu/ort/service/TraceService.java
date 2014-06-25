/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Trace;

/**
 *
 * @author victor
 */
public interface TraceService {
    void agregarTrace(Trace t);
    List<Trace> listar();
}
