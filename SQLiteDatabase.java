....... on every class used sqlite database

        DBManager dbManager;
        dbManager=new DBManager(this);



................... Add 

        ContentValues v=new ContentValues();
        v.put(DBManager.ColNAME,name.getText().toString());
        dbManager.Insert(v);
        
         
 .................. update
 
           ContentValues values=new ContentValues();
           values.put(DBManager.ColNAME, NAME.getText().toString());
     
           String[] SelectionArgs={String.valueOf(s.ID)};  // s.ID  the id of column
           dbManager.Update(values,"ID=?",SelectionArgs);

.................... delete 

            String[] SelectionArgs={s.ID};   // s.ID  the id of column
            dbManager.Delete("ID=?", SelectionArgs);



.................... DBManager class

public class DBManager {
    private SQLiteDatabase sqlDB;
    static final String DBName="databaseName";
    static final String TableName="tableName";
    static final String ColID="ID";
    static final int DBVersion=1;

   
    static final String ColNAME="NAME";


    static final String CreateTable="CREATE TABLE IF NOT EXISTS " +
            TableName+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
            ColNAME+" TEXT, " +
            " );";



    static class DatabaseHelperUser extends SQLiteOpenHelper{
        Context context;
        DatabaseHelperUser(Context context){
            super(context,DBName,null,DBVersion);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateTable);
            
     //       db.execSQL(" INSERT INTO "+TableName+" VALUES ( null , 'n1' , ' 1   3   5   7   9  ... ' , '11', 'next' , 'first' ); ");
     
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table IF EXISTS "+TableName);
            onCreate(db);

        }
    }

    public DBManager(Context context){
        DatabaseHelperUser db=new DatabaseHelperUser(context);
        sqlDB = db.getWritableDatabase();
    }


    public long Insert(ContentValues values){
        long ID = sqlDB.insert(TableName,"",values);
        return ID;
    }


    public Cursor query(String[] Projection,String Selection, String[] SelectionArgs,String SortOrder){
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        qb.setTables(TableName);
        Cursor cursor=qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder);
        return cursor;
    }

    public int Delete(String Selection,String[] SelectionArgs){
        int count = sqlDB.delete(TableName, Selection, SelectionArgs);
        return count;
    }

    public  int Update(ContentValues values,String Selection,String[] SelectionArgs){
        int count=sqlDB.update(TableName,values,Selection,SelectionArgs);
        return count;

    }

}
