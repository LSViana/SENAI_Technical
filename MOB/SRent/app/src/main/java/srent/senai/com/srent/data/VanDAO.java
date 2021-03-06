package srent.senai.com.srent.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import srent.senai.com.srent.models.Van;

public class VanDAO extends SQLiteOpenHelper implements DAO<Van, Long> {

    // It must be static for it to be initialized with the class and not the instance
    public static final String DB_NAME = "srent";
    public static final Integer DB_VERSION = 9;
    private static final String TABLE_NAME = "van";

    public VanDAO(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        //onUpgrade(getWritableDatabase(), 3, 4);
        onCreate(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "description TEXT NOT NULL, " +
                "image BLOB NOT NULL, " +
                "price NUMBER NOT NULL, " +
                "capacity NUMBER NOT NULL" +
                ");", TABLE_NAME);
        sqLiteDatabase.execSQL(sql);
        //sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(sql);
        //sqLiteDatabase.close();
    }

    public void insert(Van obj) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //
        cv.put("name", obj.getName());
        cv.put("description", obj.getDescription());
        cv.put("image", obj.getImage());
        cv.put("price", obj.getPrice());
        cv.put("capacity", obj.getCapacity());
        //
        db.insert(TABLE_NAME, null, cv);
        //db.close();
    }

    public void delete (Long id) {
        SQLiteDatabase db = getWritableDatabase();
        //
        db.delete(TABLE_NAME, "id = ?", new String[] { id.toString() });
        //db.close();
    }

    public void update(Van obj) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //
        cv.put("name", obj.getName());
        cv.put("description", obj.getDescription());
        cv.put("image", obj.getImage());
        cv.put("price", obj.getPrice());
        cv.put("capacity", obj.getCapacity());
        //
        db.update(TABLE_NAME, cv, "id = ?", new String[] { obj.getId().toString() });
        //db.close();
    }

    public List<Van> searchAll() {
        String sql = String.format("SELECT id, name, description, image, price, capacity FROM %s", TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Van> result = new ArrayList<>();
        //
        while(c.moveToNext()) {
            int columnIndex = 0;
            result.add(new Van(c.getLong(columnIndex++), c.getString(columnIndex++), c.getString(columnIndex++), c.getBlob(columnIndex++), c.getDouble(columnIndex++), c.getInt(columnIndex++)));
        }
        //
        //db.close();
        return result;
    }

    public Van search(Long id) {
        String sql = String.format("SELECT id, name, description, image, price, capacity FROM %s WHERE id = %s", TABLE_NAME, id.toString());
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        //
        while(c.moveToNext()) {
            int columnIndex = 0;
            Van result = new Van(c.getLong(columnIndex++), c.getString(columnIndex++), c.getString(columnIndex++), c.getBlob(columnIndex++), c.getDouble(columnIndex++), c.getInt(columnIndex++));
            //db.close();
            return result;
        }
        //
        //db.close();
        return null;
    }

}
