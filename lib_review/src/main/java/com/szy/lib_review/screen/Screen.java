package com.szy.lib_review.screen;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

/**
 * Name: Screen
 * Author: YJQ
 * Date: 2020/4/19
 * Desc:
 */
public class Screen {

    private static final String TAG = "Screen";


    /**
     * API:mipmap 目录主要用于存放启动图标
     *  android引入了mipmap drawables 为设计启动器图标
     *  res/
     *     drawable
     *     drawable-v24
     *                             dpi适应范围           1dp对应多少px
     *     mipmap-anydpi-v26
     *     mipmap-ldpi              120dpi(适配0~120)      0.75
     *     mipmap-mdpi              160dpi(适配120~160）     1
     *     mipmap-hdpi              240dpi(适配120~160）    1.5
     *     mipmap-xhdpi             320dpi(适配120~160）     2
     *     mipmap-xxhdpi            480dpi(适配120~160）     3
     *     mipmap-xxxhdpi           640dpi(适配120~160）     4
     *
     * Note: 图片资源如果放在drawable-v24目录下，7.0以下的机型不能找到图片
     */

    /**
     * | 级别  |  分辨率   | dpi大小（屏幕密度） |   dp：px       |
     * | ldpi  |  320*240  |       120dpi     |   dp=px*0.75   |
     * | mdpi  |  480*320  |       160dpi     |   dp=px*1      |
     * | hdpi  |  800*480  |       240dpi     |   dp=px*1.5    |
     * | Xdpi  | 1280*720  |       320dpi     |   dp=px*2      |
     * | XXdpi | 1920*1080 |       480dpi     |   dp=px*3      |
     * |XXXdpi | 2560*1440 |       640dpi     |   dp=px*4      |
     *
     *
     *
     * NOTE:(Java对于int是向下取整的，0.5f是为了四舍五入)
     *   density =  dpi/160dpi
     *   dp      =  px/density  + 0.5f
     *   px      =  dp*density  + 0.5f
     *
     */


    /**
     * 这里举个例子：
     *
     *                                  mdpi              hdpi            xhdpi           xxhdpi             xxxhdpi
     * 启动图标的尺寸为 50dp*50dp       50px*50px        75px*75px       100px*100px     150px*150px        200px*200px
     *
     *
     * 一般情况下UI会根据一种DPI密度、或分辨率的设备设计 UI，我们首先要知道UI是以哪种dpi进行设计切图的
     * 假如：以分辨率1920px*1080px，以density为3标注，那么dpi为 480dpi ，那么屏幕是 640dp*360dp
     *
     * 如果你拿到切图，这个切图是以px单位标注的，切图的设计目标手机是 480dpi，density=480/160=3 ,直接在给的数字基础上 /  3
     * 如果你拿到切图，这个切图是以px单位标注的，切图的设计目标手机是 320dpi，density=320/160=2 ,直接在给的数字基础上 /   2
     */


    /**
     * @param context
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void api(Context context) {
        //获取屏幕属性以及尺寸
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        int widthPixels = displayMetrics.widthPixels;          //分辨率为  widthPixels * heightPixels
        int heightPixels = displayMetrics.heightPixels;
        int densityDpi = displayMetrics.densityDpi;
        float density = displayMetrics.density;

        Log.i(TAG, String.format(Locale.getDefault(), "Device screen widthPixels:%d", widthPixels));
        Log.i(TAG, String.format(Locale.getDefault(), "Device screen heightPixels:%d", heightPixels));
        Log.i(TAG, String.format(Locale.getDefault(), "Device screen densityDpi:%s", densityDpi));
        Log.i(TAG, String.format(Locale.getDefault(), "Device screen density:%f", density));

        //Example 在一个屏幕分辨率为 720*1280 的设备上输出如下：
        // Device screen widthPixels:720
        // Device screen heightPixels:1280
        // Device screen densityDpi:320
        // Device screen density:2.000000

    }


    /**
     * 参考：
     * https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
     * https://segmentfault.com/a/1190000019089019
     * 传统的适配方式可能会因为设备的差异而导致显示不全的问题，想要获取比较一致性的UI体验，我们需要一种新的适配方式
     * 希望达到一种，占据屏幕宽度的比例在所有的分辨率的机型上都是一致的效果。
     *
     *
     * 找兼容突破口
     * 从dp和px的转换公式 ：px = dp * density
     * 可以看出，如果设计图宽为360dp，想要保证在所有设备计算得出的px值都正好是屏幕宽度的话，我们只能修改 density 的值。
     *
     * 默认px=dp*density，也就是屏幕总宽度dp = 屏幕宽度 px/density，这时候我们假设素有设备上的屏幕总宽度dp会等于我们设计图 widthDp
     * 那么 density = 屏幕宽度px / 设计图宽度 dp
     */


    /**
     * 个人理解，我们希望所有设备的屏幕dp都是设计图给出的dp值，那么我们在用dp作为单位的时候，就能保证宽度上空间占据的屏幕比例完全一致
     * 为了达到这个效果，我们必须手动计算并改变系统的density值
     * 根据公式density = UI切图给的屏幕宽度px值 /  设计图宽度计算的dp
     *
     *
     * 缺点：
     * 会全局影响APP的控件大小，例如一些第三方库控件，
     * 他们设计的时候可能设计图尺寸并不是像我们一样是375dp，这样就会导致控件大小变形等一些问题。
     */
}
