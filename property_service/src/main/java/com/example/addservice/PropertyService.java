package com.example.addservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Create
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Read all
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // Read by ID
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    // Update
    public Property updateProperty(Long id, Property updatedProperty) {

        Property existingProperty = getPropertyById(id);

        existingProperty.setTitle(updatedProperty.getTitle());
        existingProperty.setLocation(updatedProperty.getLocation());
        existingProperty.setPrice(updatedProperty.getPrice());
        existingProperty.setType(updatedProperty.getType());
        existingProperty.setStatus(updatedProperty.getStatus());

        return propertyRepository.save(existingProperty);
    }

    // Delete
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}