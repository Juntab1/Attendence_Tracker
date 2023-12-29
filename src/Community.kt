// class keeping track of all the people created within the application by the user
class Community {
    // mutable list that contains all the Person instances
    private lateinit var nameList : MutableList<Person>

    // set called "add"
    fun add(name : Person) {
        if (!::nameList.isInitialized){
            nameList = mutableListOf<Person>()
        }

        nameList.add(name)
    }

    // get
    fun get() : MutableList<Person> {
        return nameList
    }

    // return all names in string version
    fun allNamesDisplay() : String {
        var names : String = "Names: "

        nameList.forEach(){
            names += "${it.fullNameDisplay()}, "
        }

        names = names.removeRange(names.length - 2, names.length)

        return names
    }
}