package org.urhaug.uppercase

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
internal class UpperCaseControllerTest(@Autowired var mvc: MockMvc) {

    @Test
    fun `showUpperCaseForm renders form`() {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(view().name("index"))
    }

    @Test
    fun `makeUpperCase displays a string as upper case`() {
        this.mvc.perform(get("/uppercase")
                .param("input", "test-input")
        )
                .andExpect(status().isOk)
                .andExpect(view().name("uppercase"))
                .andExpect(model().attribute("input", "test-input"))
                .andExpect(model().attribute("uppercase", "TEST-INPUT"))
    }

    @Test
    fun `submitInput redirects to upper case view`() {
        this.mvc.perform(post("/")
                .param("input", "potatoes")
        )
                .andExpect(status().is3xxRedirection)
                .andExpect(redirectedUrl("/uppercase?input=potatoes"))
    }
}
