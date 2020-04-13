@Grab("thymeleaf-spring5")
@Controller
@RequestMapping("/")
class ContactController {
	@Autowired
	ContactRepository repository
	
	@RequestMapping(method=RequestMethod.GET)
	String home(Model model) {
		model.put("contacts", repository.findAll())
		"home"
	}
	
	@RequestMapping(method=RequestMethod.POST)
	String save(Contact contact) {
		repository.save(contact)
		"redirect:/"
	}
}