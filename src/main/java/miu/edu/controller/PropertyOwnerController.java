package miu.edu.controller;

import miu.edu.service.AddressService;
import miu.edu.service.IUserService;
import miu.edu.service.PropertyOwnerService;
import miu.edu.model.PropertyOwner;
import miu.edu.dto.selectors.UserSelectorDTO;
import miu.edu.dto.selectors.AddressSelectorDTO;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyOwnerController extends AbsEntityController<PropertyOwner> {
    
    @Autowired
    private PropertyOwnerService PropertyOwnerService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/legal-entities")
    public ModelAndView showCompanies(Model model,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size,
                                      @RequestParam("search") Optional<String> search) {
        LOG.info("In legal entity view");
        int currentPage = getCurrentPage(page);
        int pageSize = getPageSize(size);
        String searchString = getSearchString(search);
        return getListEntitiesModelView(PropertyOwnerService.getAll(searchString, currentPage, pageSize));
    }

    @Override
    public Class<?> getClassType(){
        return PropertyOwner.class;
    }
    @Override
    public String getEditViewPath(){
        return null;
    }
    @Override
    public String getListViewPath(){
        return "/legal_entity_list";
    }
    @Override
    public String getNewViewPath(){
        return null;
    }
    @Override
    public String getCrudPath(){
        return null;
    }
    @Override
    public String getListPath() { return "/legal-entities";}
    @Override
    public Dictionary<String, List<?>> getSelectLists(){
        Dictionary<String, List<?>> dictionary = new Hashtable<>();
        //Note used same attributeName "systemUser"
        dictionary.put("systemUser", userService.findAllUsers().stream().map(UserSelectorDTO::new).collect(Collectors.toList()));
        dictionary.put("address", addressService.findAll().stream().map(AddressSelectorDTO::new).collect(Collectors.toList()));
        return dictionary;
    }
}
