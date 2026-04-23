package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;
    private final ReservationRepository reservationRepository;
    private final MachineRepository machineRepository;
    public PatientController(PatientRepository patientRepository, ReservationRepository reservationRepository,  MachineRepository machineRepository) {
        this.patientRepository = patientRepository;
        this.reservationRepository = reservationRepository;
        this.machineRepository = machineRepository;
    }

    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    // wieso komme ich nicht hierhin-->
    // weil die form auf der add_patient seite mit method="post" abgeschickt wird, um das neue patient zu speichern
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return  "redirect:/patient/list";
    }
    @GetMapping("/add_reservation")
    public String addReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("patient", new Patient());
        model.addAttribute("machine", new Machine());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("machines", machineRepository.findAll());
        return "add_reservation";
    }
    @PostMapping("/add_reservation")
    public String addReservation(
            @RequestParam("patientId") int patientId,
            @RequestParam("machineType") String machineType,
            @RequestParam("dateTime") String dateTime,
            @RequestParam("bodyregion") String bodyregion,
            @RequestParam("comment") String comment) {

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Machine machine = machineRepository.findByType(machineType);

        Reservation reservation = new Reservation(patient, machine, LocalDate.parse(dateTime), bodyregion, comment);
        reservationRepository.save(reservation);
        return "redirect:/patient/reservation_list";
    }
    @GetMapping("/reservation_list")
    public String reservationList(Model model) {
        model.addAttribute("reservationList", reservationRepository.findAll());
        return "reservation_list";
    }

}
