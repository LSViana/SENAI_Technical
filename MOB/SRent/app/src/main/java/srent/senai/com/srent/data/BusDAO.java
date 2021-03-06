package srent.senai.com.srent.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import srent.senai.com.srent.models.Bus;

public class BusDAO extends SQLiteOpenHelper implements DAO<Bus, Long> {

    // It must be static for it to be initialized with the class and not the instance
    private static final String DB_NAME = VanDAO.DB_NAME;
    private static final Integer DB_VERSION = VanDAO.DB_VERSION;
    private static final String TABLE_NAME = "bus";

    public BusDAO(Context context) {
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

    public void insert(Bus obj) {
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
    }

    public void update(Bus obj) {
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

    public List<Bus> searchAll() {
        String sql = String.format("SELECT id, name, description, image, price, capacity FROM %s", TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Bus> result = new ArrayList<>();
        //
        while(c.moveToNext()) {
            int columnIndex = 0;
            result.add(new Bus(c.getLong(columnIndex++), c.getString(columnIndex++), c.getString(columnIndex++), c.getBlob(columnIndex++), c.getDouble(columnIndex++), c.getInt(columnIndex++)));
        }
        //
        //db.close();
        return result;
    }

    public Bus search(Long id) {
        String sql = String.format("SELECT id, name, description, image, price, capacity FROM %s WHERE id = %s", TABLE_NAME, id.toString());
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        //
        while(c.moveToNext()) {
            int columnIndex = 0;
            Bus result = new Bus(c.getLong(columnIndex++), c.getString(columnIndex++), c.getString(columnIndex++), c.getBlob(columnIndex++), c.getDouble(columnIndex++), c.getInt(columnIndex++));
            //db.close();
            return result;
        }
        //
        //db.close();
        return null;
    }

}
