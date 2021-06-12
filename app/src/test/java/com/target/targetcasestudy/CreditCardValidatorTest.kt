package com.target.targetcasestudy

import com.target.targetcasestudy.core.validateCreditCard
import org.junit.Assert
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 */
class CreditCardValidatorTest {
  @Test
  fun `is credit card number valid`() {
    Assert.assertTrue(
      "valid credit card number should yield true",
      validateCreditCard("4539976741512043")
    )
  }

  @Test
  fun `test when credit card number invalid`() {
    Assert.assertFalse(
      "valid credit card number should yield false",
      validateCreditCard("453997674151204")
    )
  }
}
