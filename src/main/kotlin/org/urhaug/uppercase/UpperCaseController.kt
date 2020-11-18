package org.urhaug.uppercase

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class UpperCaseController {

    @GetMapping("/")
    fun showUpperCaseForm(model: Model): String {
        return "index"
    }

    @GetMapping("uppercase")
    fun displayUpperCase(@RequestParam input: String, model: Model): String {
        model.addAttribute("input", input)
        model.addAttribute("uppercase", input.toUpperCase())
        return "uppercase"
    }

    @PostMapping("/")
    fun submitInput(@ModelAttribute("input") input: String, redirectAttributes: RedirectAttributes): String {
        redirectAttributes.addAttribute("input", input)
        return "redirect:/uppercase"
    }
}
