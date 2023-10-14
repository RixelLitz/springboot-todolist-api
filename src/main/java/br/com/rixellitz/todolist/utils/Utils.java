package br.com.rixellitz.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    //copia as propriedades de um objeto pra outro objeto
    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));

    }
    //Pegar todas propriedades nulas | atribuindo tudo para dentro do BeanUtils fazendo uma conversão para termos a mescla das nossas informações.
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd: pds){
           Object srcValue= src.getPropertyValue(pd.getName());
            if(srcValue == null){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()]; // um array de string para armazenar todos os nomes dessas minhas propriedades
        return emptyNames.toArray(result); // converte nosso conjunto de propriedades para um array string.
    }
}
