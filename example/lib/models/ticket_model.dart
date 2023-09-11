class TicketModel {
  String tag;
  String progress;
  String desc;

  TicketModel({required this.tag, required this.progress, required this.desc});

  static List<TicketModel> getElements() {
    List<TicketModel> elements = [];

    elements.add(TicketModel(
        tag: 'VSI', progress: 'IN PROGRESS', desc: 'Fleet Manager Kliens App'));
    elements.add(TicketModel(
        tag: 'VSI',
        progress: 'IN PROGRESS',
        desc: 'Confluence Page For Aifleet'));
    elements.add(TicketModel(
        tag: 'VSI',
        progress: 'IN PROGRESS',
        desc: 'Modbil App Bug Report Ticket'));
    elements.add(
        TicketModel(tag: 'CAL', progress: 'Testing', desc: 'Adjust Radar'));
    elements.add(TicketModel(
        tag: 'VSI', progress: 'IN PROGRESS', desc: 'Fleet Manager Kliens App'));
    elements.add(
        TicketModel(tag: 'CAL', progress: 'Testing', desc: 'Adjust Radar'));

    return elements;
  }
}
