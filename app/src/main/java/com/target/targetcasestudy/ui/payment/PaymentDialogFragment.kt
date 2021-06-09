package com.target.targetcasestudy.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.target.targetcasestudy.R
import com.target.targetcasestudy.core.validateCreditCard
import com.target.targetcasestudy.databinding.DialogPaymentBinding
import kotlinx.android.synthetic.main.dialog_payment.*
import javax.xml.validation.Validator

/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val binding = DialogPaymentBinding.inflate(inflater)

    binding.submit.setOnClickListener {
      val validCardMessage = if(validateCreditCard(binding.cardNumber.text.toString())) "valid" else "invalid"
      Toast.makeText(requireContext(), validCardMessage, Toast.LENGTH_LONG).show()
    }

    binding.cancel.setOnClickListener {
      dismiss()
    }

    return binding.root
  }

}