/*
 * package com.bv.gms.controllers;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import com.bv.gms.entities.Grievance; import
 * com.bv.gms.service.GrievanceService;
 * 
 * import jakarta.validation.Valid;
 * 
 * import java.util.List;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/grievances") public class GrievanceController {
 * 
 * @Autowired private GrievanceService grievanceService;
 * 
 * @PostMapping("/submit") public ResponseEntity<Grievance>
 * submitGrievance(@Valid @RequestBody Grievance grievance) { return
 * ResponseEntity.ok(grievanceService.submitGrievance(grievance)); }
 * 
 * @GetMapping("/{userId}") public ResponseEntity<List<Grievance>>
 * getUserGrievances(@PathVariable Long userId) { return
 * ResponseEntity.ok(grievanceService.getGrievancesByUserId(userId)); }
 * 
 * @GetMapping("/status/{grievanceId}") public ResponseEntity<Grievance>
 * getGrievanceStatus(@PathVariable Long grievanceId) { return
 * ResponseEntity.ok(grievanceService.getGrievanceById(grievanceId)); } }
 */