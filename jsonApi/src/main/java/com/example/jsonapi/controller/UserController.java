package com.example.jsonapi.controller;

import com.example.jsonapi.Service.RoleService;
import com.example.jsonapi.Service.UserService;
import com.example.jsonapi.model.Role;
import com.example.jsonapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController(value = "user")
public class UserController {

    @Autowired
    UserService userServiceImp;
    @Autowired
    RoleService roleService;
//    @Autowired
//    RoleController ;

    @Autowired
    RoleController role;
//        List<Role>roleList = role.getAllRole();



    // List<Role>roleList = role.getAllRole();



    @GetMapping("/role/{id}")
    public ResponseEntity<User> getRoleName (@PathVariable("id") Long roleId) throws Exception {
        Optional<User> user = userServiceImp.findUserByRoleId(roleId);
        role.getAllRole(); // this gto check if 2 controllers work together
        return ResponseEntity.ok().body(user.orElse(null));
    }

    @PostMapping("/add-user/role")//Done!!
    public ResponseEntity<String> addUser(@RequestBody User user , @RequestBody Role role){
        userServiceImp.createUser(user);
        user.addRole(role);
        return new ResponseEntity<>("User "+user.getName()+" Created !!", HttpStatus.CREATED);
    }

    @GetMapping("/role/{id}/users") //DONE!!!!!
    public ResponseEntity<List<Object>> getAllUsersByRoleId(@PathVariable("id") Long id) throws Exception {
        Optional<Role> role = roleService.findByIdRole(id);
        List<Object> user = userServiceImp.findUsersByRole(role);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user/{userId}/role") ///DONE!!!
    public ResponseEntity <Set<Role>> getRoleByUserId(@PathVariable("userId") Long userId)throws Exception{
        Optional<User> user = userServiceImp.findUserById(userId);
        Set<Role> userRoles =user.get().getRoles();
        return (ResponseEntity) ResponseEntity.ok().body(userRoles);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User>getUser(@PathVariable("id") Long id) throws Exception {
        Optional<User> user = userServiceImp.findUserById(id);
        return ResponseEntity.ok().body(user.orElse(null));
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId , @RequestBody User user ){
        userServiceImp.updateUser(userId,user);
        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable("id") Long id){
        userServiceImp.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allRelations")
    public List <User> getAllUsersAndRoleRolations (){
        //return userServiceImp.alldataInRelation();
        return userServiceImp.allRelationsJoin();
    }

    @GetMapping("/search/{name}")
    public List<User> serchByn(@PathVariable ("name") String name){
        return userServiceImp.search(name);

    }

    @GetMapping("/all")
    public List<Object> getAll(){
        return userServiceImp.findAll();
    }

}
//    @GetMapping("/getAllRole-User/{id}")
//    public List<Object> allRolesUsers(@PathVariable ("id") Long id){
//        return userServiceImp.findusersAndRoleId(id);
//    }

//***************************************
    /////// JUST NEED TEST AND ASK MALEK IF IT THE WRIGHT WAY
//    @GetMapping("/all")
//        public List<Object> getAllRelation(){
//        List<User> allUSers = userServiceImp.findAll();
//        List<Role> allRole = roleService.findAllRole();
//        List <Object> allRelation = new ArrayList<Object>(allRole);
//        allRelation.add(allUSers);
//        return allRelation;
//    }
//***************************************
//   to use Role I think i need to add Annotation  @PreAuthorize("hasRole('ADMIN')")
// I sow it in the some code on chrom but
//    @GetMapping("/")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public ResponseEntity<?> getAllUser() {
//        Optional<List<User>> optional = userService.getAllUsers();
//        if (!(optional.isPresent())) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
//        }
//        return ResponseEntity.ok(optional.get());
//    }

//***************************************
// get all user my code need it
//***************************************
//    @GetMapping("/all-user")
//    public ResponseEntity<Object> getAllUser (){
//        return (ResponseEntity<Object>) userServiceImp.getAllUsers();
//    }
///TODO          11/9/2022
// start useing the Role and Team in controller
//***************************************
// Request param
//    @PutMapping("/user/update")
//    public ResponseEntity<User> updateUserParam(@RequestParam("name") String name , @RequestBody User user ){
////        userServiceImp.updateUser(userId,user);
//        userServiceImp.
//        return new ResponseEntity<User>(user , HttpStatus.OK);
//    }
//***************************************