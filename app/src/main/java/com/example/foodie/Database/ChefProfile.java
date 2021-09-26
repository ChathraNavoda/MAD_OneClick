package com.example.foodie.Database;

import android.provider.BaseColumns;

public final class ChefProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ChefProfile() {}

    /* Inner class that defines the table contents */
    public static class Chef implements BaseColumns {
        public static final String TABLE_NAME = "ChefInfo";
        public static final String COLUMN_1 = "Username";
        public static final String COLUMN_2 = "Email";
        public static final String COLUMN_3 = "Password";
        public static final String COLUMN_4 = "Gender";

    }
}
