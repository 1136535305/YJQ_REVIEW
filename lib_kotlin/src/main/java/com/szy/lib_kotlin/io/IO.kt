package com.szy.lib_kotlin.io

import android.graphics.Bitmap
import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.Charset

/**
 * Author：yangjunquan
 * Date:  2020/10/29
 * Desc:
 */

/*
 Kotlin data class  如何序列化？
 Kotlin data class  如何指定不序列化某些属性？
 Kotlin data class  如何构建继承体系？
 */


//BaseModel是一个基类，使用open修饰属性使其能被子类继承属性
abstract class BaseModel() {
    open var baseParams1: String? = null     //备注：kotlin的所有属性、方法、类默认使用final修饰，open用于开放三者的继承权限
    open var baseParams2: String? = null
}

@Parcelize
data class DetailModel(
    var param1: String,
    var param2: String,
    @Transient var param3: String,         //@Transient 注解表明该属性不参与序列化/反序列化过程
    override var baseParams1: String?,     //使用override 表明覆写父类属性
    override var baseParams2: String?      //如果这里的属性是复杂对象，复杂对象也需要支持序列化
) : Parcelable, BaseModel()


fun parcelExample() {
    val arrays = ArrayList<DetailModel>()
    val file = File("pathName")


    //例1：序列化到文件内容
    val json1 = Gson().toJson(arrays)
    file.writeText(json1, Charset.defaultCharset())        //注：writeText函数实际内部调用了use



    //例2：文件内容反序列化
    val json2 = file.readText(Charset.defaultCharset())     //注：readText函数实际内部调用了use
    Gson().fromJson(json2, Array<DetailModel>::class.java)
}


/*
    Kotlin中流异常处理，我们这里关注一下高阶函数use
    - 实现了Closeable接口的对象可调用use函数
    - use函数会自动关闭调用者(无论中间是否出现异常)
    - Kotlin的File对象和IO流操作变得行云流水
    - use函数内部实现也是通过try-catch-finally块捕捉的方式，无需担心抛出异常导致程序退出
    - close操作在finally里执行，故无论是正常结束还是异常结束，都能正确关闭调用者，释放资源
 */

fun useExample(bitmap: Bitmap) {

    //例1：Bitmap保存为File
    val file = File("pathName")
    FileOutputStream(file).use { fos ->
        BufferedOutputStream(fos).use { bos ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos)
            bos.flush()
        }
    }


}