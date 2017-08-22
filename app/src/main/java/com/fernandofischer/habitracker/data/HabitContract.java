package com.fernandofischer.habitracker.data;

import android.provider.BaseColumns;

/**
 * Created by fernandofischer on 17/08/17.
 */

public class HabitContract {

    public static final class HabitEntry implements BaseColumns{

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_TIME = "time";

    }


}
