class NameModel {
  String name;

  NameModel({required this.name});

  static List<NameModel> getNames() {
    List<NameModel> names = [];

    names.add(NameModel(name: 'Adam'));
    names.add(NameModel(name: 'Gergely'));
    names.add(NameModel(name: 'Mark'));
    names.add(NameModel(name: 'Mate'));
    names.add(NameModel(name: 'Zoltan'));

    return names;
  }
}
