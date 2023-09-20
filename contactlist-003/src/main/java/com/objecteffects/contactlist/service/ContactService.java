package com.objecteffects.contactlist.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.objecteffects.contactlist.model.Contact;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ContactService implements Serializable {
    private static final long serialVersionUID = 1585658078828924772L;

    @PersistenceContext
    private EntityManager entityManager;
    private final Logger log = LoggerFactory.getLogger(ContactService.class);

    public void create(final Contact contact) {
        this.entityManager.persist(contact);
    }

    public List<Contact> list() {
        this.log.info("in list()");

        return this.entityManager.createQuery("select c from Contact c",
                Contact.class).getResultList();
    }

    public Contact getContact(final Long id) {
        return this.entityManager.find(Contact.class, id);
    }

    public void deleteContact(final Long id) {
        final Contact contact = this.entityManager.find(Contact.class, id);
        if (contact != null) {
            this.entityManager.remove(contact);
        }
    }
}
