package org.example.bookmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bookmanager.controller.BookController;
import org.example.bookmanager.entity.Book;
import org.example.bookmanager.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

@SpringBootTest
class BookManagerApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BookController(bookService)).build();
    }

    @Test
    void testAllBook() throws Exception {
        Book book = new Book("test-Book", "test-Author", LocalDateTime.now().minusDays(1));
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String bookString = mapper.writeValueAsString(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void testGetAllBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testGetOneBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/getOne/{bookId}", 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
