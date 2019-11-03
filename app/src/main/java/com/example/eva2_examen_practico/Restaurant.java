package com.example.eva2_examen_practico;

import java.io.Serializable;

public final class Restaurant implements Serializable {
        private int imagen;
        private String nombre;
        private String descripcion;
        private String direccionYTel;
        private int evaluacion;


        public Restaurant(int imagen, String nombre,  String descripcion, String direccionYTel, int evaluacion) {
            this.imagen = imagen;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.direccionYTel = direccionYTel;
            this.evaluacion = evaluacion;
        }

        public int getImagen() {
            return imagen;
        }

        public void setImagen(int imagen) {
            this.imagen = imagen;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDireccionYTel() { return direccionYTel; }

        public void setDireccionYTel(String direccionYTel) { this.direccionYTel = direccionYTel; }

        public int getEvaluacion() {
        return evaluacion;
    }

        public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }
}
