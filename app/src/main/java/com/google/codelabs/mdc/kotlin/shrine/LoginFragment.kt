package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        // Next 버튼 눌렀을때 패스워드 확인하고 ProductGridFragment()로 넘기는 부분
        view.next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_edit_text.error = getString(R.string.shr_error_password)
            }
            else {
                password_text_input.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        // 키 누르면 경고 없애주기
        view.password_edit_text.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = null
            }
            false
        }

        return view
    }

    // 입력하는 텍스트가 null이 아니고 길이가 8자리가 넘는지
    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }

}
