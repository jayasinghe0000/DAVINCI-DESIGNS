package com.example.davincidesigns.Database;

import android.provider.BaseColumns;

public class WorkerDetails {
    public static class Worker implements BaseColumns {

        public static final String TABLE_NAME = "worker";

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getFirst_name() {
            return first_name;
        }

        public static String getLast_name() {
            return last_name;
        }

        public static String getEmail() {
            return email;
        }

        public static String getMobile() {
            return mobile;
        }

        public static String getWorkArea() {
            return workArea;
        }

        public static String getPassword() {
            return password;
        }

        public static String getRe_password() {
            return re_password;
        }

        public static String getAddress() {
            return address;
        }

        public static String getExperience() {
            return experience;
        }

        public static  String first_name = "f_name";
        public static  String last_name = "l_name";
        public static  String email = "email";
        public static  String mobile = "m_number";
        public static  String workArea = "work_area";
        public static  String password = "password";
        public static  String re_password = "re_password";
        public static  String address = "address";
        public static  String experience = "experience";
    }



}
