package com.example.vidu

class SinhVien(hoten:String, diachi: String, namsinh: Int) {
    private  var Hoten: String=""
    private  var Diachi: String=""
    private var Namsinh: Int=0
    init {
        Hoten=hoten
        Diachi=diachi
        Namsinh=namsinh
    }

//    constructor(hoten:String, diachi: String, namsinh: Int){
//        Hoten =hoten
//        Diachi = diachi
//        Namsinh =namsinh
//
//    }
    fun setHoten(ht: String){
        Hoten =ht
    }
    fun getHoten(): String{
        return Hoten
    }

    fun setDiachi(dc: String){
        Diachi=dc
    }
    fun getDiachi():String{
        return Diachi
    }

    fun setNamsinh( ns: Int){
        if(ns>2004){
            Namsinh=2001
        }
        else{
            Namsinh =ns
        }

    }
    fun getNamsinh(): Int {
        return Namsinh
    }
    fun tinhTuoi(): Int{
        return 2021 - Namsinh
    }
}