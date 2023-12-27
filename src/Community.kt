class Community {
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

    // need to return in string version
    fun allNamesDisplay() : String {
        var names : String = "Names: "
        nameList.forEach(){
            names += "${it.fullNameDisplay()},"
        }
        names = names.removeRange(names.length - 1, names.length)
        return names
    }
}