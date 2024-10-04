package net.dixq.ryujinrokumobile

import android.app.AlertDialog
import android.app.NativeActivity
import android.view.View
import android.widget.EditText
import android.window.OnBackInvokedDispatcher

class GameActivity : NativeActivity() {
    var AppActivity: NativeActivity? = null
    var EditView: EditText? = null
    var AlBuilder: AlertDialog.Builder? = null

    // 入力された文字列を保存するメンバー変数
    var InputString: String? = null

    // 文字列の入力が終わったら 1 にするフラグ用変数
    var InputEnd: Int = 0

    // 文字列入力ダイアログを開始する
    fun StartInputStringDialog() {
        // NativeActivity の参照をメンバー変数に保存しておく
        AppActivity = this

        // 文字列の入力が終わったら 1 にするフラグを 0 で初期化
        InputEnd = 0

        // UIスレッドで実行する処理を登録する
        runOnUiThread { // 文字列入力の View を作成
            EditView = EditText(AppActivity)

            // ダイアログを作成
            AlBuilder = AlertDialog.Builder(AppActivity)

            // ダイアログのタイトルを設定
            AlBuilder!!.setTitle("テキスト入力ダイアログ")

            // ダイアログに文字列の View をセット
            AlBuilder!!.setView(EditView)

            // ダイアログに OK ボタンを追加
            AlBuilder!!.setPositiveButton("OK") { dialog, whichButton ->
                // OK ボタンが押されたときに呼ばれる関数
                // 入力された文字列をメンバー変数に保存
                InputString = EditView!!.text.toString()

                // 入力されたかどうかのフラグを立てる
                InputEnd = 1

                // タイトルバーとナビゲーションバーを非表示にする処理
                val decor = this@GameActivity.window.decorView
                decor.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            }

            // ダイアログを表示
            AlBuilder!!.show()
        }
    }

}