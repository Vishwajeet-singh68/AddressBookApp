package com.addressbook.app.controller;

import com.addressbook.app.entity.Contact;
import com.addressbook.app.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/add")
	public void addContact(@RequestBody Contact contact) {
		contactService.addContact(contact);
	}
	
	@PatchMapping("/edit")
	public Contact edit(@RequestBody Contact contact) {
		return contactService.editContact(contact);
	}

    @DeleteMapping("/delete")
    public void delete(@RequestParam long id){
        contactService.deleteById(id);
    }
	
	@GetMapping("/all")
	public Iterable<Contact> getAllContacts() {
		return contactService.getAll();
	}
}
