package com.kevin.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/**
 * SharePreference缓存工具类
 * @author Kevin
 * 
 */
public class SharePrefUtil {
    private final static String SP_NAME = "sp";
    private static SharedPreferences mSp;

    public static void saveBoolean(Context context, String key, boolean value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().putBoolean(key, value).commit();
    }

    public static void saveString(Context context, String key, String value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().putString(key, value).commit();

    }

    public static void saveLong(Context context, String key, long value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().putLong(key, value).commit();
    }

    public static void saveInt(Context context, String key, int value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().putInt(key, value).commit();
    }

    public static void saveFloat(Context context, String key, float value) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().putFloat(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        return mSp.getString(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        return mSp.getInt(key, defValue);
    }

    public static long getLong(Context context, String key, long defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        return mSp.getLong(key, defValue);
    }

    public static float getFloat(Context context, String key, float defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        return mSp.getFloat(key, defValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        return mSp.getBoolean(key, defValue);
    }

    public static void saveObj(Context context, String key, Object object) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            String objBase64 = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString(key, objBase64).commit();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getObj(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        String objBase64 = mSp.getString(key, null);
        if (TextUtils.isEmpty(objBase64))
            return null;
        byte[] base64Bytes = Base64.decode(objBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
        ObjectInputStream ois;
        Object obj = null;
        try {
            ois = new ObjectInputStream(bais);
            obj = (Object) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 删除对应缓存
     * 
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static void removeKey(Context context, String key) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().remove(key).commit();
    }

    public static String removeKey(Context context, String key, String defValue) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        //		return mSp.getString(key, defValue);
        mSp.edit().remove(key).commit();
        return mSp.getString(key, defValue);
    }

    /**
     * 清空缓存
     * @param context
     */
    public static void clear(Context context) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        mSp.edit().clear().commit();
    }

    /**
     * 清空缓存
     * @param context
     */
    public static void clear(Context context, String... keys) {
        if (mSp == null)
            mSp = context.getSharedPreferences(SP_NAME, 0);
        Map<String, ?> map = mSp.getAll();
        if (null != map && map.size() > 0) {
            Set<String> keySet = map.keySet();
            if (keys != null) {
                keySet.removeAll(Arrays.asList(keys));
            }
            if (null != keySet && keySet.size() > 0) {
                for (String key : keySet) {
                    removeKey(context, key);
                }
            }
        }
    }

    /**
     * 根据key和预期的value类型获取value的值
     * 
     * @param key
     * @param clazz
     * @return
     */
    public <T> T getValue(Context context, String key, Class<T> clazz) {
        if (context == null) {
            throw new RuntimeException("请先调用带有context，name参数的构造！");
        }
        if (mSp == null) {
            mSp = context.getSharedPreferences(SP_NAME, 0);
        }
        return getValue(key, clazz, mSp);
    }

    /**
     * 针对复杂类型存储<对象>
     * 
     * @param key
     * @param val
     */
    public void setObject(Context context, String key, Object object) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(SP_NAME, 0);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {

            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            Editor editor = mSp.edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Context context, String key, Class<T> clazz) {
        if (mSp == null) {
            mSp = context.getSharedPreferences(SP_NAME, 0);
        }
        if (mSp.contains(key)) {
            String objectVal = mSp.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 对于外部不可见的过渡方法
     * 
     * @param key
     * @param clazz
     * @param sp
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T> T getValue(String key, Class<T> clazz, SharedPreferences sp) {
        T t;
        try {

            t = clazz.newInstance();

            if (t instanceof Integer) {
                return (T) Integer.valueOf(sp.getInt(key, 0));
            } else if (t instanceof String) {
                return (T) sp.getString(key, "");
            } else if (t instanceof Boolean) {
                return (T) Boolean.valueOf(sp.getBoolean(key, false));
            } else if (t instanceof Long) {
                return (T) Long.valueOf(sp.getLong(key, 0L));
            } else if (t instanceof Float) {
                return (T) Float.valueOf(sp.getFloat(key, 0L));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
            Log.e("system", "类型输入错误或者复杂类型无法解析[" + e.getMessage() + "]");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.e("system", "类型输入错误或者复杂类型无法解析[" + e.getMessage() + "]");
        }
        Log.e("system", "无法找到" + key + "对应的值");
        return null;
    }
}
