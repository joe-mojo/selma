/*
 * Copyright 2013 Xebia and Séven Le Mesle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package fr.xebia.extras.selma.beans;

import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class PersonOut {

    public byte[] keyStore;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private int age;
    private Long[] indices;
    private Collection<String> tags;
    private EnumOut enumIn;
    private AddressOut address;
    private AddressOut addressBis;
    private Boolean natural;
    private String biography;

    public byte[] getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(byte[] keyStore) {
        this.keyStore = keyStore;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Boolean isNatural() {
        return natural;
    }

    public void setNatural(Boolean natural) {
        this.natural = natural;
    }

    public EnumOut getEnumIn() {
        return enumIn;
    }

    public void setEnumIn(EnumOut enumIn) {
        this.enumIn = enumIn;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

    public Long[] getIndices() {
        return indices;
    }

    public void setIndices(Long[] indices) {
        this.indices = indices;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressOut getAddress() {
        return address;
    }

    public void setAddress(AddressOut address) {
        this.address = address;
    }

    public AddressOut getAddressBis() {
        return addressBis;
    }

    public void setAddressBis(AddressOut addressBis) {
        this.addressBis = addressBis;
    }
}
